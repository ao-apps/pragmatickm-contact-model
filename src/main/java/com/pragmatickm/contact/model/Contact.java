/*
 * pragmatickm-contact-model - Contacts nested within SemanticCMS pages and elements.
 * Copyright (C) 2013, 2014, 2015, 2016  AO Industries, Inc.
 *     support@aoindustries.com
 *     7262 Bull Pen Cir
 *     Mobile, AL 36695
 *
 * This file is part of pragmatickm-contact-model.
 *
 * pragmatickm-contact-model is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * pragmatickm-contact-model is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with pragmatickm-contact-model.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.pragmatickm.contact.model;

import com.aoindustries.aoserv.client.validator.Email;
import com.aoindustries.lang.NullArgumentException;
import com.aoindustries.util.AoCollections;
import static com.aoindustries.util.StringUtility.nullIfEmpty;
import com.semanticcms.core.model.Element;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Contact extends Element {

	private String title;
	private String first;
	private String middle;
	private String nick;
	private String last;
	private String maiden;
	private String suffix;
	private String company;
	private String department;
	private String jobTitle;
	private List<Email> emails;
	private List<PhoneNumber> phoneNumbers;
	private List<Im> ims;
	private List<String> webPages;
	private List<Address> addresses;

	@Override
	public Contact freeze() {
		synchronized(lock) {
			if(emails != null) emails = AoCollections.optimalUnmodifiableList(emails);
			if(phoneNumbers != null) phoneNumbers = AoCollections.optimalUnmodifiableList(phoneNumbers);
			if(ims != null) ims = AoCollections.optimalUnmodifiableList(ims);
			if(webPages != null) webPages = AoCollections.optimalUnmodifiableList(webPages);
			if(addresses != null) addresses = AoCollections.optimalUnmodifiableList(addresses);
			super.freeze();
			return this;
		}
	}

	public String getTitle() {
		synchronized(lock) {
			return title;
		}
	}

	public void setTitle(String title) {
		synchronized(lock) {
			checkNotFrozen();
			this.title = nullIfEmpty(title);
		}
	}

	public String getFirst() {
		synchronized(lock) {
			return first;
		}
	}

	public void setFirst(String first) {
		synchronized(lock) {
			checkNotFrozen();
			this.first = nullIfEmpty(first);
		}
	}

	public String getMiddle() {
		synchronized(lock) {
			return middle;
		}
	}

	public void setMiddle(String middle) {
		synchronized(lock) {
			checkNotFrozen();
			this.middle = nullIfEmpty(middle);
		}
	}

	public String getNick() {
		synchronized(lock) {
			return nick;
		}
	}

	public void setNick(String nick) {
		synchronized(lock) {
			checkNotFrozen();
			this.nick = nullIfEmpty(nick);
		}
	}

	public String getLast() {
		synchronized(lock) {
			return last;
		}
	}

	public void setLast(String last) {
		synchronized(lock) {
			checkNotFrozen();
			this.last = nullIfEmpty(last);
		}
	}

	public String getMaiden() {
		synchronized(lock) {
			return maiden;
		}
	}

	public void setMaiden(String maiden) {
		synchronized(lock) {
			checkNotFrozen();
			this.maiden = nullIfEmpty(maiden);
		}
	}

	public String getSuffix() {
		synchronized(lock) {
			return suffix;
		}
	}

	public void setSuffix(String suffix) {
		synchronized(lock) {
			checkNotFrozen();
			this.suffix = nullIfEmpty(suffix);
		}
	}

	public String getCompany() {
		synchronized(lock) {
			return company;
		}
	}

	public void setCompany(String company) {
		synchronized(lock) {
			checkNotFrozen();
			this.company = nullIfEmpty(company);
		}
	}

	public String getDepartment() {
		synchronized(lock) {
			return department;
		}
	}

	public void setDepartment(String department) {
		synchronized(lock) {
			checkNotFrozen();
			this.department = nullIfEmpty(department);
		}
	}

	public String getJobTitle() {
		synchronized(lock) {
			return jobTitle;
		}
	}

	public void setJobTitle(String jobTitle) {
		synchronized(lock) {
			checkNotFrozen();
			this.jobTitle = nullIfEmpty(jobTitle);
		}
	}

	public List<Email> getEmails() {
		synchronized(lock) {
			if(emails == null) return Collections.emptyList();
			if(frozen) return emails;
			return AoCollections.unmodifiableCopyList(emails);
		}
	}

	public void addEmail(Email email) {
		synchronized(lock) {
			checkNotFrozen();
			if(emails == null) emails = new ArrayList<Email>();
			emails.add(email);
		}
	}

	public List<PhoneNumber> getPhoneNumbers() {
		synchronized(lock) {
			if(phoneNumbers == null) return Collections.emptyList();
			if(frozen) return phoneNumbers;
			return AoCollections.unmodifiableCopyList(phoneNumbers);
		}
	}

	public void addPhoneNumber(PhoneNumber phoneNumber) {
		synchronized(lock) {
			checkNotFrozen();
			if(phoneNumbers == null) phoneNumbers = new ArrayList<PhoneNumber>();
			phoneNumbers.add(phoneNumber);
		}
	}

	public List<Im> getIms() {
		synchronized(lock) {
			if(ims == null) return Collections.emptyList();
			if(frozen) return ims;
			return AoCollections.unmodifiableCopyList(ims);
		}
	}

	public void addIm(Im im) {
		synchronized(lock) {
			checkNotFrozen();
			if(ims == null) ims = new ArrayList<Im>();
			ims.add(im);
		}
	}

	public List<String> getWebPages() {
		synchronized(lock) {
			if(webPages == null) return Collections.emptyList();
			if(frozen) return webPages;
			return AoCollections.unmodifiableCopyList(webPages);
		}
	}

	public void addWebPage(String webPage) {
		webPage = nullIfEmpty(webPage);
		NullArgumentException.checkNotNull(webPage, "webPage");
		synchronized(lock) {
			checkNotFrozen();
			if(webPages == null) webPages = new ArrayList<String>();
			webPages.add(webPage);
		}
	}

	public List<Address> getAddresses() {
		synchronized(lock) {
			if(addresses == null) return Collections.emptyList();
			if(frozen) return addresses;
			return AoCollections.unmodifiableCopyList(addresses);
		}
	}

	public void addAddress(Address address) {
		synchronized(lock) {
			checkNotFrozen();
			if(addresses == null) addresses = new ArrayList<Address>();
			addresses.add(address);
		}
	}

	@Override
	public void appendLabel(Appendable out) throws IOException {
		// Get copies because writes to out can block, don't hold lock while blocking on I/O
		String title;
		String first;
		String middle;
		String nick;
		String last;
		String maiden;
		String suffix;
		String jobTitle;
		String company;
		String department;
		synchronized(lock) {
			title = this.title;
			first = this.first;
			middle = this.middle;
			nick = this.nick;
			last = this.last;
			maiden = this.maiden;
			suffix = this.suffix;
			jobTitle = this.jobTitle;
			company = this.company;
			department = this.department;
		}
		boolean didOne = false;
		if(title != null) {
			if(didOne) out.append(' ');
			out.append(title);
			didOne = true;
		}
		if(first != null) {
			if(didOne) out.append(' ');
			out.append(first);
			didOne = true;
		}
		if(middle != null) {
			if(didOne) out.append(' ');
			out.append(middle);
			didOne = true;
		}
		if(nick != null) {
			if(didOne) out.append(' ');
			out.append('“');
			out.append(nick);
			out.append('”');
			didOne = true;
		}
		if(last != null) {
			if(didOne) out.append(' ');
			out.append(last);
			didOne = true;
		}
		if(maiden != null) {
			if(didOne) out.append(' ');
			out.append('(');
			out.append(maiden);
			out.append(')');
			didOne = true;
		}
		if(suffix != null) {
			if(didOne) out.append(", ");
			out.append(suffix);
			didOne = true;
		}
		if(!didOne && jobTitle != null) {
			out.append(jobTitle);
			didOne = true;
		}
		if(!didOne && company != null) {
			out.append(company);
			didOne = true;
		}
		if(!didOne && department != null) {
			out.append(department);
			didOne = true;
		}
		if(!didOne) {
			out.append("Contact");
		}
	}

	@Override
	protected String getDefaultIdPrefix() {
		return "contact";
	}
}
