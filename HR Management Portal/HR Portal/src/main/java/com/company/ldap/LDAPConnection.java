package com.company.ldap;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;


public class LDAPConnection {

	private static DirContext ldapContext;

	private static final String DOMAIN_NAME="@companyName.com"; // Domain Name

	private static final String PROVIDER_DOMAIN="corp.companyName.com"; // Domain Provider Name

	private static final String PROVIDER_URL="ldap://blr-adc-2."; // Provider URl For LDAP

	//Specify the attributes to return
	private static String returnedAtts[]={ AttributeType.DISTINGUISHEDNAME, AttributeType.TITLE,AttributeType.EMPLOYEENUMBER,
		AttributeType.CN, AttributeType.NAME, AttributeType.UID, AttributeType.SN, AttributeType.GIVENNAME, 
		AttributeType.MEMBEROF, AttributeType.SAMACCOUNTNAME,AttributeType.MAILNICKNAME,
		AttributeType.MAIL, AttributeType.MANAGER, AttributeType.DEPARTMENT, AttributeType.TELEPHONENUMBER,
		AttributeType.DISPLAYNAME, AttributeType.USERPRINCIPALNAME, AttributeType.OTHERMAILBOX, AttributeType.EMPLOYEEID,AttributeType.PHOTO};

	public static boolean authenticate(UserDetails user) {
		boolean flag=false;
		try
		{
			System.out.println("D�but du test Active Directory");
			Hashtable<String, String> ldapEnv = new Hashtable<String, String>(11);
			ldapEnv.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
			ldapEnv.put(Context.PROVIDER_URL,  PROVIDER_URL+PROVIDER_DOMAIN+":389");
			ldapEnv.put(Context.SECURITY_AUTHENTICATION, "simple");
			ldapEnv.put(Context.SECURITY_PRINCIPAL, user.getUserName()+DOMAIN_NAME);
			ldapEnv.put(Context.SECURITY_CREDENTIALS, user.getPassword());
			System.out.println("Coming here n1"+user.getUserName()+user.getPassword());
			ldapContext = new InitialDirContext(ldapEnv);
			flag=true;
		}
		catch (Exception e)
		{
			System.out.println(" Search error: " + e);
			e.printStackTrace();
			flag=false;
		}
		return flag;
	}


	public static void close() {
		try {
			ldapContext.close();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static NamingEnumeration<SearchResult> searchResult(UserDetails user) {
		int totalResults = 0;
		System.out.println("inside search result");
		NamingEnumeration<SearchResult> answer=null;
		try {
			SearchControls searchCtls = new SearchControls();
			searchCtls.setReturningAttributes(returnedAtts);
			//Specify the search scope
			searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);
			//specify the LDAP search filter
			String searchFilter = "(&(userPrincipalName="+user.getUserName()+DOMAIN_NAME+")(objectClass=user))";
			//initialize counter to total the results
			System.out.println("Coming here n2");
			// Search for objects using the filter
			answer= ldapContext.search(toDC(PROVIDER_DOMAIN), searchFilter, searchCtls);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Total results: " + totalResults);
		return answer;
	}


	private static String toDC(final String domainName) {
		final StringBuilder buf = new StringBuilder();
		for (final String token : domainName.split("\\.")) {
			if (token.length() == 0) {
				continue; // defensive check
			}
			if (buf.length() > 0) {
				buf.append(","); 
			}
			buf.append("DC=").append(token);
		}
		System.out.println("buf::"+buf.toString());
		return buf.toString();
	}

}
