package com.apple.design;
/**
Widget Factory: A Widget Factory consists of three departments - Assembly, QC, Shipping. The factory is managed by a Factory Manager. 
The Factory makes and ships three kinds of widgets: Indigo Widgets, Tan Widgets and Mauve Widgets. Indigo and Tan support function shake. 
Tan and Mauve support function drag. 

Assembly: Assembly makes the widgets in independent lines for each widget. After each widget is made, Assembly sends it to QC and sends a
 notification to Factory Manager.

QC: QC doesn't know about Indigo, Tan or Mauve. They only know about widgets that can be shaken or dragged. The shake function returns -1
 if the widget is defective. Similarly the drag function returns -1 if the widget is defective. If a widget is not defective,
  it is sent to Shipping and QC notifies Factory Manager.

Shipping: When a widget is received by Shipping a notification of the type of widget is sent to Factory Manager.

Defects: Historically, a certain percentage of Indigo, Tan and Mauve widgets are defective.

Model the widgets, the functions, the factory (and the departments) and the Factory Manager.

Run a simulation of the factory for a configurable number of seconds, with a configurable production rate of Indigo widgets 
at i/second, Tan widgets at t/second and Mauve widgets at m/second, and a defect rate for each widget type.

At the end of the simulation, the test will verify that the number of widgets assembled (given the rate) = number of defective 
widgets + number of shipped widgets.
**/


class Factory{
	
	
	
}
/*import java.util.*;
import org.junit.*;
import org.junit.runner.JUnitCore;

public class Solution {

    static class Factory {
        Factory(int indigoProductionRate, int tanProductionRate, int mauveProductionRate, double indigoErrorRate, double tanErrorRate, double mauveErrorRate) {
          
            // TODO
        }


        public void run(int seconds) throws Exception {
            // TODO
            
          
          
          
        }

        public Number assembled(Class<? extends Widget> widget) {
            return 0; // FIXME
        }

        public Number defective(Class<? extends Widget> widget) {
            return 0; // FIXME
        }

        public Number shipped(Class<? extends Widget> widget) {
            return 0; // FIXME
        }
    }

    static class Widget {
      
    }

    @Test
    public void simulation() throws Exception {
        double indigoErrorRate = 0.02;
        double tanErrorRate = 0.01;
        double mauveErrorRate = 0.05;
        int indigoProductionRate = 10;
        int tanProductionRate = 5;
        int mauveProductionRate = 1;
        int simulationDurationInSeconds = 2;

        final Factory factory = new Factory(indigoProductionRate, tanProductionRate, mauveProductionRate, indigoErrorRate, tanErrorRate, mauveErrorRate);
        factory.run(simulationDurationInSeconds);

        final List<Class<Widget>> widgetTypes = new ArrayList<>(); // FIXME - initialize with list of widget types
        Assert.assertTrue(!widgetTypes.isEmpty());
        widgetTypes.stream().forEach(c -> {
            Assert.assertEquals(factory.shipped(c).intValue(), factory.assembled(c).intValue() - factory.defective(c).intValue());
        });
        Assert.assertEquals(new Integer((indigoProductionRate + tanProductionRate + mauveProductionRate) * simulationDurationInSeconds), widgetTypes.stream().map(c -> factory.assembled(c).intValue()).reduce(0, (x,y) -> x+y));
    }

    public static void main(String[] args) throws Exception {
        JUnitCore.main("Solution");
    }
}




public interface Shake{

  int canShake();
}

public interface Drag{

  int canDrag();
}




class Indigo extends Widget implements Shake{

  
  
  boolean shake = false;
  public int canShake(){

    if(shake){
        return 1;
      }else{
        return -1;
      }
    
    
    
    
    
  }
  
}

class Tan extends Widget implements Shake,Drag{
    boolean shake = false;
  boolean drag = false;
  public int canShake(){

    //should be both shakeable and draggable
    if(shake && drag){
        return 1;
      }else{
        return -1;
      }


}

class Mauve extends Widget implements Drag{
  boolean drag = false;
  public int canShake(){

    if(drag){
        return 1;
      }else{
        return -1;
      }


}
  
public class AssemblyLine{
  
  Q
    public voi assemble()

}  
interface Department{

public void process(Widget widget);
}
  
class Assembly implements Department {
  //
  Department qc;
  FactoryManager factoryManager;
  
  pubic void process(Widget widget){
  
  
  
  qc.process(widget);
  }

}  
class QC implements Department {
  //Shipping
  Department shipping;
  FactoryManager factoryManager;
  
  pubic void process(Widget w){

  if(w instanceOf Shake.class){
    int s = w.shake();
    if(s==-1){
      factorymanager.
    }
    
  }  
  if(w instanceOf Drag.class){
    int s = w.drag();
    
    
  }  
  
  
  shipping.process();
  }
  //check quaity
  
  //

}   
class Shipping implements Department {
  
  FactoryManager factoryManager;
  public void process(Widget w){
  
    
    
  }

} 
  class Factorymanager {
    
    
    
  }
  
public class Factory {

}*/
