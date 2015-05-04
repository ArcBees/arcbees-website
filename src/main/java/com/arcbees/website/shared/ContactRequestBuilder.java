/*
 * Copyright 2015 ArcBees Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.arcbees.website.shared;

public class ContactRequestBuilder {
    private String email;
    private String name;
    private String message;

    private ContactRequestBuilder() {
    }

    public static ContactRequestBuilder newRequest() {
        return new ContactRequestBuilder();
    }

    public ContactRequestBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactRequestBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public ContactRequestBuilder withMessage(String message) {
        this.message = message;
        return this;
    }

    public ContactRequest build() {
        ContactRequest contactRequest = new ContactRequest();
        contactRequest.setEmail(email);
        contactRequest.setName(name);
        contactRequest.setMessage(message);

        return contactRequest;
    }
}
