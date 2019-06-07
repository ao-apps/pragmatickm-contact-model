/*
 * pragmatickm-contact-model - Contacts nested within SemanticCMS pages and elements.
 * Copyright (C) 2013, 2014, 2015, 2016, 2017, 2019  AO Industries, Inc.
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

import com.aoindustries.lang.NullArgumentException;
import com.aoindustries.net.Email;
import com.aoindustries.util.AoCollections;
import static com.aoindustries.util.StringUtility.nullIfEmpty;
import com.semanticcms.core.model.Element;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Contact extends Element {

	private volatile String title;
	private volatile String first;
	private volatile String middle;
	private volatile String nick;
	private volatile String last;
	private volatile String maiden;
	private volatile String suffix;
	private volatile String company;
	private volatile String department;
	private volatile String jobTitle;
	private List<Email> emails;
	private List<PhoneNumber> phoneNumbers;
	private List<Im> ims;
	private List<String> webPages;
	private List<Address> addresses;

	@Override
	public Contact freeze() {
		synchronized(lock) {
			if(!frozen) {
				if(emails != null) emails = AoCollections.optimalUnmodifiableList(emails);
				if(phoneNumbers != null) phoneNumbers = AoCollections.optimalUnmodifiableList(phoneNumbers);
				if(ims != null) ims = AoCollections.optimalUnmodifiableList(ims);
				if(webPages != null) webPages = AoCollections.optimalUnmodifiableList(webPages);
				if(addresses != null) addresses = AoCollections.optimalUnmodifiableList(addresses);
				super.freeze();
			}
		}
		return this;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		checkNotFrozen();
		this.title = nullIfEmpty(title);
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		checkNotFrozen();
		this.first = nullIfEmpty(first);
	}

	public String getMiddle() {
		return middle;
	}

	public void setMiddle(String middle) {
		checkNotFrozen();
		this.middle = nullIfEmpty(middle);
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		checkNotFrozen();
		this.nick = nullIfEmpty(nick);
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		checkNotFrozen();
		this.last = nullIfEmpty(last);
	}

	public String getMaiden() {
		return maiden;
	}

	public void setMaiden(String maiden) {
		checkNotFrozen();
		this.maiden = nullIfEmpty(maiden);
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		checkNotFrozen();
		this.suffix = nullIfEmpty(suffix);
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		checkNotFrozen();
		this.company = nullIfEmpty(company);
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		checkNotFrozen();
		this.department = nullIfEmpty(department);
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		checkNotFrozen();
		this.jobTitle = nullIfEmpty(jobTitle);
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
			if(emails == null) emails = new ArrayList<>();
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
			if(phoneNumbers == null) phoneNumbers = new ArrayList<>();
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
			if(ims == null) ims = new ArrayList<>();
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
			if(webPages == null) webPages = new ArrayList<>();
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
			if(addresses == null) addresses = new ArrayList<>();
			addresses.add(address);
		}
	}

	@Override
	public void appendLabel(Appendable out) throws IOException {
		// Get copies because writes to out can block, don't hold lock while blocking on I/O
		boolean didOne = false;
		String _title = this.title;
		if(_title != null) {
			if(didOne) out.append(' ');
			out.append(_title);
			didOne = true;
		}
		String _first = this.first;
		if(_first != null) {
			if(didOne) out.append(' ');
			out.append(_first);
			didOne = true;
		}
		String _middle = this.middle;
		if(_middle != null) {
			if(didOne) out.append(' ');
			out.append(_middle);
			didOne = true;
		}
		String _nick = this.nick;
		if(_nick != null) {
			if(didOne) out.append(' ');
			out.append('“');
			out.append(_nick);
			out.append('”');
			didOne = true;
		}
		String _last = this.last;
		if(_last != null) {
			if(didOne) out.append(' ');
			out.append(_last);
			didOne = true;
		}
		String _maiden = this.maiden;
		if(_maiden != null) {
			if(didOne) out.append(' ');
			out.append('(');
			out.append(_maiden);
			out.append(')');
			didOne = true;
		}
		String _suffix = this.suffix;
		if(_suffix != null) {
			if(didOne) out.append(", ");
			out.append(_suffix);
			didOne = true;
		}
		if(!didOne) {
			String _jobTitle = this.jobTitle;
			if(_jobTitle != null) {
				out.append(_jobTitle);
			} else {
				String _company = this.company;
				if(_company != null) {
					out.append(_company);
				} else {
					String _department = this.department;
					if(_department != null) {
						out.append(_department);
					} else {
						out.append("Contact");
					}
				}
			}
		}
	}

	@Override
	protected String getDefaultIdPrefix() {
		return "contact";
	}
}
