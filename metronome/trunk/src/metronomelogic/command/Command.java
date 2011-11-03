
package metronomelogic.command;

public interface Command {
  void execute() ;

  String getName();
  
  void setName(String name);
  
}
