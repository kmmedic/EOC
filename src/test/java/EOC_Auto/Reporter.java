
package EOC_Auto;

import org.testng.ITestResult;
import org.testng.TestRunner;
import org.testng.collections.Lists;
import org.testng.collections.Maps;

import java.util.List;
import java.util.Map;
import java.util.Vector;




public class Reporter {
  // when tests are run in parallel, each thread may be working with different
  // 'current test result'. Also, this value should be inherited if the test code
  // spawns its own thread.
  private static ThreadLocal<ITestResult> m_currentTestResult = new InheritableThreadLocal<ITestResult>();


  private static List<String> m_output = new Vector<String>();

  private static Map<ITestResult, List<Integer>> m_methodOutputMap = Maps.newHashMap();

  public static void setCurrentTestResult(ITestResult m) {
    m_currentTestResult.set(m);
  }

  public static List<String> getOutput() {
    return m_output;
  }


 public static void clear() {
   m_methodOutputMap.clear();
   m_output.clear();
 }

 private static synchronized void log(String s, ITestResult m) {
   // synchronization needed to ensure the line number and m_output are updated atomically
   int n = getOutput().size();
   List<Integer> lines = m_methodOutputMap.get(m);
   if (lines == null) {
     lines = Lists.newArrayList();
     m_methodOutputMap.put(m, lines);
   }
   lines.add(n);
   getOutput().add(s);
 }


public static void log(String s) {
  log(s, getCurrentTestResult());
}



public static void Mlog(String s, int level, boolean logToStandardOut) {
  if (TestRunner.getVerbose() >= level) {
    log(s, getCurrentTestResult());
    if (logToStandardOut) {
      System.out.println(s);
    }
  }
}



public static void log(String s, boolean logToStandardOut) {
  log(s, getCurrentTestResult());
  if (logToStandardOut) {
    System.out.println(s);
  }
}


public static void log(String s, int level) {
  if (TestRunner.getVerbose() >= level) {
    log(s, getCurrentTestResult());
  }
}


  public static ITestResult getCurrentTestResult() {
    return m_currentTestResult.get();
  }

  public static synchronized List<String> getOutput(ITestResult tr) {
    List<String> result = Lists.newArrayList();
    List<Integer> lines = m_methodOutputMap.get(tr);
    if (lines != null) {
      for (Integer n : lines) {
        result.add(getOutput().get(n));
      }
    }

    return result;
  }
}

 

 

 

 

 
