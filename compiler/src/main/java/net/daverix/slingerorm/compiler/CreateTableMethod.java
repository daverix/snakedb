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

class CreateTableMethod implements StorageMethod {
    private final String methodName;
    private final MapperDescription mapperDescription;

    public CreateTableMethod(String methodName, MapperDescription mapperDescription) {
        this.mapperDescription = mapperDescription;
        this.methodName = methodName;
    }

    @Override
    public void write(Writer writer) throws IOException {
        if(writer == null) throw new IllegalArgumentException("writer is null");

        writer.write("    @Override\n");
        writer.write("    public void " + methodName + "() {\n");
        writer.write("        db.execSQL(" + mapperDescription.getVariableName() + ".createTable());\n");
        writer.write("    }\n");
        writer.write("\n");
    }

    @Override
    public Collection<String> getImports() {
        return Collections.emptyList();
    }

    @Override
    public MapperDescription getMapper() {
        return mapperDescription;
    }
}
