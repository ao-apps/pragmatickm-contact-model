/*
 * pragmatickm-contact-model - Contacts nested within SemanticCMS pages and elements.
 * Copyright (C) 2015, 2016, 2019, 2020  AO Industries, Inc.
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

public class Im {

	private final ImType type;
	private final String handle;
	private final String comment;

	public Im(ImType type, String handle, String comment) {
		this.type = NullArgumentException.checkNotNull(type, "type");
		this.handle = NullArgumentException.checkNotNull(handle, "handle");
		this.comment = nullIfEmpty(comment);
	}

	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Im)) return false;
		Im other = (Im)o;
		return
			type == other.type
			&& handle.equals(other.handle)
			&& Objects.equals(comment, other.comment)
		;
	}

	@Override
	public int hashCode() {
		int hash = type.hashCode();
		hash = hash * 31 + handle.hashCode();
		hash = hash * 31 + Objects.hashCode(comment);
		return hash;
	}

	public ImType getType() {
		return type;
	}

	public String getHandle() {
		return handle;
	}

	public String getComment() {
		return comment;
	}
}
