package com.github.thmarx.cms.modules.pug;

/*-
 * #%L
 * pebble-module
 * %%
 * Copyright (C) 2023 Marx-Software
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

import com.github.thmarx.cms.api.ServerProperties;
import com.github.thmarx.cms.api.feature.features.DBFeature;
import com.github.thmarx.cms.api.feature.features.ServerPropertiesFeature;
import com.github.thmarx.cms.api.feature.features.ThemeFeature;
import com.github.thmarx.cms.api.module.CMSModuleContext;
import com.github.thmarx.modules.api.ModuleLifeCycleExtension;
import com.github.thmarx.modules.api.annotation.Extension;

/**
 *
 * @author t.marx
 */
@Extension(ModuleLifeCycleExtension.class)
public class PugLifecycleExtension extends ModuleLifeCycleExtension<CMSModuleContext> {

	static PugTemplateEngine templateEngine;
	
	@Override
	public void init() {
	}

	@Override
	public void activate() {
		templateEngine = new PugTemplateEngine(
				getContext().get(DBFeature.class).db().getFileSystem(), 
				getContext().get(ServerPropertiesFeature.class).serverProperties(), 
				getContext().get(ThemeFeature.class).theme()
		);
	}

	@Override
	public void deactivate() {
	}
}
