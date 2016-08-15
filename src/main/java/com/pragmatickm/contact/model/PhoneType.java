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

public enum PhoneType {
	WORK("Work", "contact_work_number"),
	TOLLFREE("Toll Free", "contact_toll_free"),
	HOME("Home", "contact_home_number"),
	MOBILE("Mobile", "contact_mobile_phone"),
	PAGER("Pager", "contact_pager_number"),
	FAX("Fax", "contact_fax_number");

	private final String label;
	private final String cssClass;

	private PhoneType(String label, String cssClass) {
		this.label = label;
		this.cssClass = cssClass;
	}

	public String getLabel() {
		return label;
	}

	public String getCssClass() {
		return cssClass;
	}
}
