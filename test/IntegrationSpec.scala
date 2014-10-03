import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._
import play.api.test._
import play.api.test.Helpers._
import play.Logger

@RunWith(classOf[JUnitRunner])
class IntegrationSpec extends Specification {

  "Index page" should {

    "work from within a browser" in new WithBrowser {
      browser goTo("http://localhost:" + port)
      browser.pageSource must not be empty
    }

    "display a username field" in new WithBrowser {
      browser goTo("http://localhost:" + port)
      browser.find("input[id='username']") should have length (1)
    }
    
    "display a password field" in new WithBrowser {
      browser goTo("http://localhost:" + port)
      browser.find("input[id='password']") should have length (1)
    }
    
    "display a login button" in new WithBrowser {
      browser goTo("http://localhost:" + port)
      browser.find("input[id='submit']") should have length (1)
    }
    
    "display a sign-up link" in new WithBrowser {
      browser goTo("http://localhost:" + port)
      browser.find("a[id='sign-up']") should have length (1)
    }
  }
}
