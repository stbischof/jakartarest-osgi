/**
 * Copyright (c) 2012 - 2022 Data In Motion and others.
 * All rights reserved. 
 * 
 * This program and the accompanying materials are made available under the terms of the 
 * Eclipse Public License v2.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *     Data In Motion - initial API and implementation
 *     Stefan Bishof - API and implementation
 *     Tim Ward - implementation
 */
package org.eclipse.osgitech.rest.runtime;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.osgitech.rest.factories.InjectableFactory;
import org.glassfish.jersey.internal.inject.InjectionManager;
import org.glassfish.jersey.server.ApplicationHandler;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

/**
 * Wrapps the Resource Config and allows a hacky mechanism to delegate InjectionManager from the 
 * {@link ServletContainer} {@link ApplicationHandler} to the {@link InjectableFactory}
 * 
 * @author Mark Hoffmann
 * @author Juergen Albert
 * @since 2 Dec 2020
 */
public class ResourceConfigWrapper {

	public ResourceConfig config;
	
	List<InjectableFactory<?>> factories = new LinkedList<>();
	
	void setInjectionManager(InjectionManager manager) {
		factories.forEach(f -> f.setInjectionManager(manager));
	}
	
}
