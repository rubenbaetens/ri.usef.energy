/*
 * Copyright 2015-2016 USEF Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package energy.usef.brp.workflow.transformer;

import energy.usef.core.model.Connection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ConnectionTransformerTest {

    @Test
    public void testConnectionTransformer() {
        List<Connection> connectionList = buildConnectionList();
        List<String> connectionStringList = ConnectionTransformer.transformConnections(connectionList);

        for (int i = 0; i <= 9; i++) {
            Assert.assertEquals(connectionStringList.get(i),connectionList.get(i).getEntityAddress());
        }
    }

    @Test (expected = IllegalArgumentException.class)
    public void testConnectionTransformerNullist() {
        ConnectionTransformer.transformConnections(null);
    }

    @Test
    public void testConstructorIsPrivate() throws Exception {
        Constructor<ConnectionTransformer> constructor = ConnectionTransformer.class.getDeclaredConstructor();
        Assert.assertTrue("Constructor should be private", Modifier.isPrivate(constructor.getModifiers()));
    }

    private List<Connection> buildConnectionList() {
        List<Connection> connectionList = new ArrayList<>();

        for (int i = 0; i <= 9; i++) {
            Connection connection = new Connection();
            connection.setEntityAddress("ean" + i + ".11111111");
            connectionList.add(connection);
        }

        return connectionList;
    }

}
