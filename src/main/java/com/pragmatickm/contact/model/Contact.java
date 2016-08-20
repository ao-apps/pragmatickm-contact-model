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
		super.freeze();
		return this;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		checkNotFrozen();
		this.title = title;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		checkNotFrozen();
		this.first = first;
	}

	public String getMiddle() {
		return middle;
	}

	public void setMiddle(String middle) {
		checkNotFrozen();
		this.middle = middle;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		checkNotFrozen();
		this.nick = nick;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		checkNotFrozen();
		this.last = last;
	}

	public String getMaiden() {
		return maiden;
	}

	public void setMaiden(String maiden) {
		checkNotFrozen();
		this.maiden = maiden;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		checkNotFrozen();
		this.suffix = suffix;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		checkNotFrozen();
		this.company = company;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		checkNotFrozen();
		this.department = department;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		checkNotFrozen();
		this.jobTitle = jobTitle;
	}

	public List<Email> getEmails() {
		if(emails == null) return Collections.emptyList();
		return Collections.unmodifiableList(emails);
	}

	public void addEmail(Email email) {
		checkNotFrozen();
		if(emails == null) emails = new ArrayList<Email>();
		emails.add(email);
	}

	public List<PhoneNumber> getPhoneNumbers() {
		if(phoneNumbers == null) return Collections.emptyList();
		return Collections.unmodifiableList(phoneNumbers);
	}

	public void addPhoneNumber(PhoneNumber phoneNumber) {
		checkNotFrozen();
		if(phoneNumbers == null) phoneNumbers = new ArrayList<PhoneNumber>();
		phoneNumbers.add(phoneNumber);
	}

	public List<Im> getIms() {
		if(ims == null) return Collections.emptyList();
		return Collections.unmodifiableList(ims);
	}

	public void addIm(Im im) {
		checkNotFrozen();
		if(ims == null) ims = new ArrayList<Im>();
		ims.add(im);
	}

	public List<String> getWebPages() {
		if(webPages == null) return Collections.emptyList();
		return Collections.unmodifiableList(webPages);
	}

	public void addWebPage(String webPage) {
		checkNotFrozen();
		if(webPages == null) webPages = new ArrayList<String>();
		webPages.add(webPage);
	}

	public List<Address> getAddresses() {
		if(addresses == null) return Collections.emptyList();
		return Collections.unmodifiableList(addresses);
	}

	public void addAddress(Address address) {
		checkNotFrozen();
		if(addresses == null) addresses = new ArrayList<Address>();
		addresses.add(address);
	}

	@Override
	public void appendLabel(Appendable out) throws IOException {
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
	public String getListItemCssClass() {
		return "list-item-contact";
	}

	@Override
	protected String getDefaultIdPrefix() {
		return "contact";
	}
}
