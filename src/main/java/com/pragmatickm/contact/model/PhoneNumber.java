/*
 * pragmatickm-contact-model - Contacts nested within SemanticCMS pages and elements.
 * Copyright (C) 2013, 2014, 2015, 2016, 2019, 2020, 2021, 2022  AO Industries, Inc.
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

import static com.aoapps.lang.Strings.nullIfEmpty;

import com.aoapps.lang.NullArgumentException;
import java.util.Objects;

public class PhoneNumber {

  private final PhoneType type;
  private final String number;
  private final String comment;

  public PhoneNumber(PhoneType type, String number, String comment) {
    this.type = NullArgumentException.checkNotNull(type, "type");
    this.number = NullArgumentException.checkNotNull(number, "number");
    this.comment = nullIfEmpty(comment);
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof PhoneNumber)) {
      return false;
    }
    PhoneNumber other = (PhoneNumber) o;
    return
        type == other.type
            && number.equals(other.number)
            && Objects.equals(comment, other.comment);
  }

  @Override
  public int hashCode() {
    int hash = type.hashCode();
    hash = hash * 31 + number.hashCode();
    hash = hash * 31 + Objects.hashCode(comment);
    return hash;
  }

  public PhoneType getType() {
    return type;
  }

  public String getNumber() {
    return number;
  }

  public String getComment() {
    return comment;
  }
}
