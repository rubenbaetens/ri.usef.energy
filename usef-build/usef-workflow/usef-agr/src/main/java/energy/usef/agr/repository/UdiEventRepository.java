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

package energy.usef.agr.repository;

import energy.usef.agr.model.PowerContainer;
import energy.usef.agr.model.UdiEvent;
import energy.usef.core.repository.BaseRepository;

import java.util.List;

import javax.persistence.TemporalType;

import org.joda.time.LocalDate;

/**
 * Repository class in charge of the operations related to the {@link UdiEvent} entities.
 */
public class UdiEventRepository extends BaseRepository<UdiEvent> {

    /**
     * Finds all the {@link UdiEvent} entities for the given period.
     *
     * @param period {@link LocalDate} period.
     * @return a {@link List} of {@link UdiEvent}.
     */
    public List<UdiEvent> findUdiEventsForPeriod(LocalDate period) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ue ");
        sql.append("FROM UdiEvent ue ");
        sql.append("WHERE ue.period = :period ");
        return getEntityManager().createQuery(sql.toString(), UdiEvent.class)
                .setParameter("period", period.toDateMidnight().toDate(), TemporalType.DATE)
                .getResultList();
    }

    /**
     * Delete all {@link UdiEvent} objects for a certain date.
     *
     * @param period
     * @return the number of {@link UdiEvent} objects deleted.
     */
    public int cleanup(LocalDate period) {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM UdiEvent ue ");
        sql.append("WHERE ue.period = :period)");

        return entityManager.createQuery(sql.toString()).setParameter("period", period.toDateMidnight().toDate()).executeUpdate();
    }

}
