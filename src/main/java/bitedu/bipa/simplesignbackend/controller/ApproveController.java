package bitedu.bipa.simplesignbackend.controller;

import bitedu.bipa.simplesignbackend.model.dto.ApprovalDocDetailDTO;
import bitedu.bipa.simplesignbackend.model.dto.ApprovalDocReqDTO;
import bitedu.bipa.simplesignbackend.model.dto.ApprovalPermissionResDTO;
import bitedu.bipa.simplesignbackend.service.ApproveService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/approve")
public class ApproveController {

    private final ApproveService approveService;

    public ApproveController(ApproveService approveService) {
        this.approveService = approveService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> approveRegister(@RequestBody ApprovalDocReqDTO approvalDocReqDTO) {
        approveService.registerApprovalDoc(approvalDocReqDTO);
        return ResponseEntity.ok("ok");
    }

    @PostMapping("/approval/{num}")
    public ResponseEntity<String> approveApprovalDoc(@PathVariable("num") int approvalDocId) {
        approveService.approveApprovalDoc(approvalDocId);
        return ResponseEntity.ok("ok");
    }

    @PostMapping("/return/{num}")
    public ResponseEntity<String> returnApprovalDoc(@PathVariable("num") int approvalDocId) {
        approveService.returnApprovalDoc(approvalDocId);
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/detail/{num}")
    public ResponseEntity<ApprovalDocDetailDTO> showDetailApprovalDoc(@PathVariable("num") int approvalDocId) {
        ApprovalDocDetailDTO approvalDocDetailDTO =  approveService.showDetailApprovalDoc(approvalDocId);
        return ResponseEntity.ok(approvalDocDetailDTO);

    }

    @PatchMapping("/{num}")
    public ResponseEntity<String>  updateApporvalDoc(@PathVariable("num") int approvalDocId, @RequestBody ApprovalDocReqDTO approvalDocReqDTO) {
        approveService.updateApprovalDoc(approvalDocId, approvalDocReqDTO);
        return ResponseEntity.ok("ok");
    }

    @DeleteMapping("/{num}")
    public ResponseEntity<String> removeApprovalDoc(@PathVariable("num") int approvalDocId) {
        approveService.removeApprovalDoc(approvalDocId);
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/PermissionList/{num}")
    public ResponseEntity<Boolean> getPermissionList(@PathVariable("num") int approvalDocId){
        boolean hasPermission =  approveService.hasPermission(approvalDocId);
        return ResponseEntity.ok(hasPermission);
    }

    @GetMapping("/hasApproval/{num}")
    public ResponseEntity<Boolean> getHasApproval(@PathVariable("num") int approvalDocId){
        boolean hasApproval = approveService.getHasApproval(approvalDocId);
        return ResponseEntity.ok(hasApproval);
    }
    @PostMapping("/cancel/{num}")
    public ResponseEntity<String> cancelApproval(@PathVariable("num") int approvalDocId) {
        approveService.cancelApproval(approvalDocId);
        return ResponseEntity.ok("ok");
    }

}
