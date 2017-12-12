/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.site.navigation.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.BaseModelPermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.site.navigation.model.SiteNavigationMenu;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Pavel Savinov
 * @deprecated As of 1.0.0, with no direct replacement
 */
@Component(
	property = {"model.class.name=com.liferay.site.navigation.model.SiteNavigationMenu"},
	service = BaseModelPermissionChecker.class
)
@Deprecated
public class SiteNavigationMenuPermission
	implements BaseModelPermissionChecker {

	public static void check(
			PermissionChecker permissionChecker, long siteNavigationMenuId,
			String actionId)
		throws PortalException {

		_siteNavigationMenuModelResourcePermission.check(
			permissionChecker, siteNavigationMenuId, actionId);
	}

	public static void check(
			PermissionChecker permissionChecker,
			SiteNavigationMenu siteNavigationMenu, String actionId)
		throws PortalException {

		_siteNavigationMenuModelResourcePermission.check(
			permissionChecker, siteNavigationMenu, actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, long siteNavigationMenuId,
			String actionId)
		throws PortalException {

		return _siteNavigationMenuModelResourcePermission.contains(
			permissionChecker, siteNavigationMenuId, actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker,
			SiteNavigationMenu siteNavigationMenu, String actionId)
		throws PortalException {

		return _siteNavigationMenuModelResourcePermission.contains(
			permissionChecker, siteNavigationMenu, actionId);
	}

	@Override
	public void checkBaseModel(
			PermissionChecker permissionChecker, long groupId, long primaryKey,
			String actionId)
		throws PortalException {

		_siteNavigationMenuModelResourcePermission.check(
			permissionChecker, primaryKey, actionId);
	}

	@Reference(
		target = "(model.class.name=com.liferay.site.navigation.model.SiteNavigationMenu)",
		unbind = "-"
	)
	protected void setModelResourcePermission(
		ModelResourcePermission<SiteNavigationMenu> modelResourcePermission) {

		_siteNavigationMenuModelResourcePermission = modelResourcePermission;
	}

	private static ModelResourcePermission<SiteNavigationMenu>
		_siteNavigationMenuModelResourcePermission;

}