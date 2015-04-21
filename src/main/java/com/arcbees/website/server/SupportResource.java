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

package com.arcbees.website.server;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.arcbees.appengine.mail.EmailBuilder;
import com.arcbees.appengine.mail.EmailSender;
import com.arcbees.website.shared.ContactRequest;
import com.arcbees.website.shared.EndPoints;

@Path(EndPoints.SUPPORT)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SupportResource {
    private static final String TO = "christian.goudreau@arcbees.com";
    private static final String CONTACT_REQUEST = "Contact Request";
    private static final String FROM = "zom.bee@arcbees.com";

    private final EmailSender emailSender;

    @Inject
    SupportResource(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    @POST
    public Response sendContactEmail(ContactRequest contactRequest) {
        com.arcbees.appengine.mail.Email convertedEmail = EmailBuilder.to(TO)
                .fromAddress(FROM)
                .fromPersonal(CONTACT_REQUEST)
                .body(getEmailContent(contactRequest))
                .subject(CONTACT_REQUEST)
                .build();

        emailSender.send(convertedEmail);

        return Response.ok().build();
    }

    private String getEmailContent(ContactRequest contactRequest) {
        return new StringBuilder().append("Name: ")
                .append(contactRequest.getName())
                .append('\n')
                .append("Email :")
                .append(contactRequest.getEmail())
                .append("\n\n")
                .append(contactRequest.getMessage())
                .toString();
    }
}
