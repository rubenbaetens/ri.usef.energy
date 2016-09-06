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

package energy.usef.core.workflow.dto;

import java.math.BigInteger;

/**
 * Data Transfer Object conveying the PTU values for a Prognosis.
 */
public class PtuPrognosisDto {

    private BigInteger ptuIndex;
    private BigInteger power;

    /**
     * Default constructor.
     */
    public PtuPrognosisDto() {
        // empty constructor, do nothing.
    }

    /**
     * Constructor with all the possible values for a {@link PtuPrognosisDto}.
     *
     * @param ptuIndex {@link java.math.BigInteger} index of the PTU.
     * @param power    {@link java.math.BigInteger} power value for the PTU.
     */
    public PtuPrognosisDto(BigInteger ptuIndex, BigInteger power) {
        this.ptuIndex = ptuIndex;
        this.power = power;
    }

    public BigInteger getPtuIndex() {
        return ptuIndex;
    }

    public void setPtuIndex(BigInteger ptuIndex) {
        this.ptuIndex = ptuIndex;
    }

    public BigInteger getPower() {
        return power;
    }

    public void setPower(BigInteger power) {
        this.power = power;
    }
}
