/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2013 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * http://glassfish.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */

package org.glassfish.jersey.server.mvc;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.glassfish.jersey.Beta;

/**
 * Used to annotate JAX-RS resources and resource methods to provide reference to an error template if an exception has been
 * raised during processing a request (resource method invocation).
 * <p/>
 * The processing of this annotation is similar to the processing of {@link Template} annotation with the difference that the
 * thrown exception (or an object derived from the exception) is used as a model for the defined template.
 * <p/>
 * By default every {@link Exception exception} is mapped to a viewable and passed to the MVC runtime for further processing.
 * <p/>
 * Note: The {@link ErrorTemplate} annotation can be used even in case when neither {@link Viewable viewable} is used as return
 * value of a resource method nor {@link Template} annotation is used to annotate the resource method or resource class.
 *
 * @author Michal Gajdos (michal.gajdos at oracle.com)
 * @see Template
 * @see org.glassfish.jersey.server.mvc.spi.AbstractErrorTemplateMapper
 * @since 2.3
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@Beta
public @interface ErrorTemplate {

    /**
     * The template name that should be used to display an error raised during processing a request. The template name may be
     * declared as absolute template name if the name begins with a '/', otherwise the template name is recognized to be relative.
     */
    String name() default "";
}