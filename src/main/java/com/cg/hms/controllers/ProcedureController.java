package com.cg.hms.controllers;
  
  
  
  import java.util.List;
  
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.http.HttpStatus; 
  import org.springframework.http.ResponseEntity; 
  import org.springframework.web.bind.annotation.GetMapping; 
  import org.springframework.web.bind.annotation.PathVariable; 
  import org.springframework.web.bind.annotation.PostMapping;  
  import org.springframework.web.bind.annotation.RequestBody; 
  import org.springframework.web.bind.annotation.RequestMapping; 
  import org.springframework.web.bind.annotation.RequestMethod; 
  import org.springframework.web.bind.annotation.RequestParam;
  import org.springframework.web.bind.annotation.RestController;
  import com.cg.hms.entities.Procedures;
  import com.cg.hms.services.ProcedureServiceImpl;
  
  
  @RestController
  @RequestMapping(value="/api/procedure")
  public class ProcedureController{
	  private ProcedureServiceImpl service;
  
  @Autowired public void setService(ProcedureServiceImpl service) {
  this.service = service;
  }
  
  @PostMapping public ResponseEntity<Procedures>saveProcedure(@RequestBody Procedures proc) { 
	  Procedures pro = service.saveProcedure(proc);
      return new ResponseEntity<>(pro,HttpStatus.OK);
  }
  
  @GetMapping(value="/") 
  public ResponseEntity<List<Procedures>> getprocedure()
  {
  
  List<Procedures> list = service.getAllProcedures();
  return new ResponseEntity<>(list,HttpStatus.OK); 
  }
  
  @GetMapping(value="/cost") public ResponseEntity <Procedures>
  getid(@RequestParam(value="id") int id) {
	  Procedures obj = service.getCostOfProcedureById(id); 
	  return new ResponseEntity<>(obj,HttpStatus.OK); 
	  }
  
  @GetMapping(value="/cost/{name}")
  public ResponseEntity<Procedures>searchName(@PathVariable String name) { 
  Procedures obj = service.getCostOfProcedureByName(name);
  return new ResponseEntity<>(obj,HttpStatus.OK); 
  }
  
  @RequestMapping(method= RequestMethod.PUT, value = "/cost") 
  public ResponseEntity <Procedures>updateCost(@RequestBody Procedures procedure,@RequestParam("empid") Integer empid) { 
  Procedures procedures = service.updateCostOfProcedure(empid, procedure);
  return new ResponseEntity<>(procedures,HttpStatus.OK);  
  }
  
  @RequestMapping(method= RequestMethod.PUT, value = "/name") public
  ResponseEntity <Procedures>updateName(@RequestBody Procedures procedure,@RequestParam("empid") Integer empid) { 
	  Procedures procedures = service.updateNameOfProcedureB(empid, procedure); 
	  return new ResponseEntity<>(procedures,HttpStatus.OK); 
   } 
  }
  
 