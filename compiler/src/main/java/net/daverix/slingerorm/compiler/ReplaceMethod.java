/*
 * Copyright 2015 David Laurell
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.daverix.slingerorm.compiler;

import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.Collections;

class ReplaceMethod implements StorageMethod {
    private final String methodName;
    private String databaseEntityTypeName;
    private final String databaseEntityTypeQualifiedName;
    private final MapperDescription mapperDescription;

    ReplaceMethod(String methodName,
                  String databaseEntityTypeName,
                  String databaseEntityTypeQualifiedName,
                  MapperDescription mapperDescription) {
        this.methodName = methodName;
        this.databaseEntityTypeName = databaseEntityTypeName;
        this.databaseEntityTypeQualifiedName = databaseEntityTypeQualifiedName;

        this.mapperDescription = mapperDescription;
    }

    @Override
    public void write(Writer writer) throws IOException {
        writer.write("    @Override\n");
        writer.write("    public void " + methodName + "(" + databaseEntityTypeName + " item) {\n");
        writer.write("        if (item == null) throw new IllegalArgumentException(\"entity is null\");\n");
        writer.write("\n");
        writer.write("        \n");
        writer.write("        db.replace(" + mapperDescription.getVariableName() + ".getTableName(),\n");
        writer.write("                " + mapperDescription.getVariableName() + ".mapValues(item));\n");
        writer.write("    }\n");
        writer.write("\n");
    }

    @Override
    public Collection<String> getImports() {
        return Collections.singletonList(databaseEntityTypeQualifiedName);
    }

    @Override
    public MapperDescription getMapper() {
        return mapperDescription;
    }
}
