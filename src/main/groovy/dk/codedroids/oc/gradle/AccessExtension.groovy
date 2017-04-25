/*
 * Copyright (c) 2016-2017 CodeDroids ApS (http://www.codedroids.dk)
 *
 * This file is part of OpenCms plugin for Gradle.
 *
 * OpenCms plugin is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * OpenCms plugin is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with OpenCms plugin . If not, see <http://www.gnu.org/licenses/>.
 */
package dk.codedroids.oc.gradle

/**
 * @author Claus Priisholm
 */
trait AccessExtension {

    /**
     * Since Project API throws exception if asked for a non-existing extension it gets wrapped here for convenience
     * @return
     */
    def opencmsExt(String key) {
        return opencmsExt(key,null)
    }

    def opencmsExt(String key, def defaultValue) {
        // full access path out, makes it easier to mock
        if(this.getProject().hasProperty(OpenCmsPlugin.EXT_NAME))
            return this.getProject().getProperties().get(OpenCmsPlugin.EXT_NAME)?."${key}" ?: defaultValue
        else
            return defaultValue
    }

}
