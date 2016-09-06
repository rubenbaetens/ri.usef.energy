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

package energy.usef.cro.repository;

import energy.usef.core.repository.BaseRepository;
import energy.usef.cro.model.DistributionSystemOperator;

import java.util.List;

import javax.ejb.Stateless;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

/**
 * Distribution System Operator Repository for CRO.
 */
@Stateless
public class DistributionSystemOperatorRepository extends
        BaseRepository<DistributionSystemOperator> {

    /**
     * Find the DistributionSystemOperator entity by its domain, creates if non existent.
     *
     * @param domain distribution system operator domain
     *
     * @return DistributionSystemOperator entity
     */
    @SuppressWarnings("unchecked")
    @Transactional(value = TxType.REQUIRES_NEW)
    public DistributionSystemOperator findOrCreateByDomain(String domain) {
        List<DistributionSystemOperator> list = getEntityManager().createQuery(
                "SELECT dso FROM DistributionSystemOperator dso WHERE dso.domain = :domain")
                .setParameter("domain", domain).getResultList();
        if (list.isEmpty()) {
            DistributionSystemOperator dso = new DistributionSystemOperator();
            dso.setDomain(domain);
            persist(dso);
            return dso;
        } else {
            return list.get(0);
        }
    }

    /**
     * Find the DistributionSystemOperator entity by its domain.
     * 
     * @param domain
     * @return DistributionSystemOperator or null if not found
     */
    @SuppressWarnings("unchecked")
    public DistributionSystemOperator findByDomain(String domain) {
        List<DistributionSystemOperator> list = getEntityManager().createQuery(
                "SELECT dso FROM DistributionSystemOperator dso WHERE dso.domain = :domain").setParameter("domain", domain)
                .getResultList();
        if (list.isEmpty()) {
            return null;
        } else {
            return list.get(0);
        }
    }

}
