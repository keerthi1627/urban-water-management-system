package com.example.urban_water_management_system.Controller;

import com.example.urban_water_management_system.Entity.Pipeline;
import com.example.urban_water_management_system.Enum.Status;
import com.example.urban_water_management_system.Service.PipelineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pipeline")
public class PipelineController {

    private final PipelineService pipelineService;

    public PipelineController(PipelineService pipelineService){

        this.pipelineService = pipelineService;
    }

    // add pipeline
    @PostMapping("/add")
    public Pipeline addPipeline(@RequestBody Pipeline pipeline) {

        return pipelineService.addPipeline(pipeline);
    }

    // get pipeline by id
    @GetMapping("/get/{id}")
    public Pipeline getPipelineById(@PathVariable("id") Long pipeId) {

        return pipelineService.getPipelineById(pipeId);
    }

    // get all pipelines
    @GetMapping("/all")
    public List<Pipeline> getAllPipelines() {

        return pipelineService.getAllPipelines();
    }

    // update current flow
    @PutMapping("/update/{id}")
    public Pipeline updateCurrFlow(@PathVariable("id") Long pipeId, @RequestParam Long updatedFlow) {

        return pipelineService.updateCurrFlow(pipeId, updatedFlow);
    }

    //update status
    @PutMapping("/updateStatus/{id}")
    public String updateStatus(@PathVariable("id") Long pipeId, @RequestParam Status updatedStatus){

        pipelineService.updateStatus(pipeId, updatedStatus);

        return "Status updated successfully";
    }

    // delete pipeline
    @DeleteMapping("/delete/{id}")
    public String deletePipeline(@PathVariable("id") Long pipeId) {

        pipelineService.deletePipeline(pipeId);

        return "Pipeline deleted successfully";
    }
}
