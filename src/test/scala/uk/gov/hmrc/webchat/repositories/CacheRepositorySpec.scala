/*
 * Copyright 2020 HM Revenue & Customs
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

package uk.gov.hmrc.webchat.repositories

import org.scalatest.Matchers._
import org.scalatest.WordSpecLike
import org.scalatestplus.mockito.MockitoSugar.mock
import play.api.inject.bind
import play.api.inject.guice.GuiceApplicationBuilder
import uk.gov.hmrc.webchat.utils.TestCoreGet

class CacheRepositorySpec extends WordSpecLike {

  private val mockedGet = mock[TestCoreGet]

  private val builder = new GuiceApplicationBuilder().configure(
    "microservice.services.digital-engagement-platform-partials.coreGetClass" -> "uk.gov.hmrc.webchat.utils.TestCoreGet",
    "microservice.services.digital-engagement-platform-partials.host" -> "localhost",
    "microservice.services.digital-engagement-platform-partials.port" -> 1111,
    "microservice.services.digital-engagement-platform-partials.protocol" -> "http"
  ).overrides(
    bind[TestCoreGet].toInstance(mockedGet)
  )

  "CacheRepository" should {
    "be able to get as injected instance" in {
      val repository = builder.injector().instanceOf[CacheRepository]
      repository should not be null
    }
  }
}