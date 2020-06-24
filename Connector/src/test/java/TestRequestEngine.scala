import com.summer.connector.http.engine.{RequestEngine, RequestEngineImpl}
import org.junit.{After, Before, Test}

class TestRequestEngine {


  var requestEngine: RequestEngine[TestDataModel] = null

  @Before
  def setUp(): Unit = {
    requestEngine = new RequestEngineImpl[TestDataModel]
  }

  @Test
  def testSend(): Unit = {

  }

  @After
  def cleanUp(): Unit = {

  }

}
