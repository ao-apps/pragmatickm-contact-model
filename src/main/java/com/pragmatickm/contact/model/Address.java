/*
 * pragmatickm-contact-model - Contacts nested within SemanticCMS pages and elements.
 * Copyright (C) 2013, 2014, 2015, 2016, 2019, 2020  AO Industries, Inc.
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
import static com.aoindustries.lang.Strings.nullIfEmpty;
import java.util.Objects;

public class Address {

	private final AddressType type;
	private final String address1;
	private final String address2;
	private final String city;
	private final String stateProv;
	private final String zipPostal;
	private final String country;
	private final String comment;

	public Address(
		AddressType type,
		String address1,
		String address2,
		String city,
		String stateProv,
		String zipPostal,
		String country,
		String comment
	) {
		this.type = NullArgumentException.checkNotNull(type, "type");
		this.address1 = nullIfEmpty(address1);
		this.address2 = nullIfEmpty(address2);
		this.city = nullIfEmpty(city);
		this.stateProv = nullIfEmpty(stateProv);
		this.zipPostal = nullIfEmpty(zipPostal);
		this.country = nullIfEmpty(country);
		this.comment = nullIfEmpty(comment);
	}

	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Address)) return false;
		Address other = (Address)o;
		return
			type == other.type
			&& Objects.equals(address1, other.address1)
			&& Objects.equals(address2, other.address2)
			&& Objects.equals(city, other.city)
			&& Objects.equals(stateProv, other.stateProv)
			&& Objects.equals(zipPostal, other.zipPostal)
			&& Objects.equals(country, other.country)
			&& Objects.equals(comment, other.comment)
		;
	}

	@Override
	public int hashCode() {
		return Objects.hash(
			address1,
			address2,
			city,
			stateProv,
			zipPostal,
			country,
			comment
		);
	}

	public AddressType getType() {
		return type;
	}

	public String getAddress1() {
		return address1;
	}

	public String getAddress2() {
		return address2;
	}

	public String getCity() {
		return city;
	}

	public String getStateProv() {
		return stateProv;
	}

	public String getZipPostal() {
		return zipPostal;
	}

	public String getCountry() {
		return country;
	}

	public String getComment() {
		return comment;
	}
}
