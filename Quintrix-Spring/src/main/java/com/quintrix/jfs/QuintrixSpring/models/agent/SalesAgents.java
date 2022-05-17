
package com.quintrix.jfs.QuintrixSpring.models.agent;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SalesAgents {

  @JsonProperty("agentsList")
  private List<Agents> agentsList = null;

  @JsonProperty("agentsList")
  public List<Agents> getAgentsList() {
    return agentsList;
  }

  @JsonProperty("agentsList")
  public void setAgentsList(List<Agents> agentsList) {
    this.agentsList = agentsList;
  }
}
