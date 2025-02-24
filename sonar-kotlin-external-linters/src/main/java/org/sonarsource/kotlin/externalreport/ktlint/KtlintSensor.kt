/*
 * SonarSource Kotlin
 * Copyright (C) 2018-2023 SonarSource SA
 * mailto:info AT sonarsource DOT com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonarsource.kotlin.externalreport.ktlint

import org.sonar.api.batch.sensor.SensorContext
import org.sonar.api.notifications.AnalysisWarnings
import org.sonarsource.kotlin.api.frontend.AbstractPropertyHandlerSensor
import org.sonarsource.kotlin.api.common.RULE_REPOSITORY_LANGUAGE

class KtlintSensor(val analysisWarnings: AnalysisWarnings) : AbstractPropertyHandlerSensor(
    analysisWarnings,
    LINTER_KEY,
    LINTER_NAME,
    REPORT_PROPERTY_KEY,
    RULE_REPOSITORY_LANGUAGE,
) {
    companion object {
        const val LINTER_KEY = "ktlint"
        const val LINTER_NAME = "ktlint"
        const val REPORT_PROPERTY_KEY = "sonar.kotlin.ktlint.reportPaths"
    }

    override fun reportConsumer(context: SensorContext) = ReportImporter(analysisWarnings, context)::importFile
}
