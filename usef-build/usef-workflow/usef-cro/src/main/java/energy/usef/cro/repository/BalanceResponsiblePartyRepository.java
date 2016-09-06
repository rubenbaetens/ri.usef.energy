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
import energy.usef.cro.model.BalanceResponsibleParty;

import java.util.List;

import javax.ejb.Stateless;

/**
 * BalanceResponsibleParty Repository for CRO.
 */
@Stateless
public class BalanceResponsiblePartyRepository extends BaseRepository<BalanceResponsibleParty> {
    /**
     * Gets BalanceResponsibleParty entity by its domain.
     *
     * @param domain BalanceResponsibleParty domain
     *
     * @return BalanceResponsibleParty entity
     */
    @SuppressWarnings("unchecked")
    public BalanceResponsibleParty findByDomain(String domain) {

        List<BalanceResponsibleParty> result = entityManager
                .createQuery("SELECT brp FROM BalanceResponsibleParty brp WHERE brp.domain = :domain")
                .setParameter("domain", domain).getResultList();
        if (result == null || result.isEmpty()) {
            return null;
        }
        return result.get(0);
    }

}
