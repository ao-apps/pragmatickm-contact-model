/*
 * pragmatickm-contact-model - Contacts nested within SemanticCMS pages and elements.
 * Copyright (C) 2013, 2014, 2015, 2016, 2020, 2022  AO Industries, Inc.
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
 * along with pragmatickm-contact-model.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.pragmatickm.contact.model;

public enum AddressType {
  POBOX(
      "POBOX",
      "POBOX",
      "pragmatickm-contact-address-pobox"
  ),
  HOME(
      "Home Address",
      "Home",
      "pragmatickm-contact-address-home"
  ),
  WORK(
      "Work Address",
      "Work",
      "pragmatickm-contact-address-work"
  );

  private final String label;
  private final String shortLabel;
  private final String cssClass;

  private AddressType(
      String label,
      String shortLabel,
      String cssClass
  ) {
    this.label = label;
    this.shortLabel = shortLabel;
    this.cssClass = cssClass;
  }

  public String getLabel() {
    return label;
  }

  public String getShortLabel() {
    return shortLabel;
  }

  // TODO: This CSS Class should go in pragmatickm-contact-servlet
  public String getCssClass() {
    return cssClass;
  }
}
