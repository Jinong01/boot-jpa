package kr.it.academy.jpa.controller;

import kr.it.academy.jpa.entity.ItemEntity;
import kr.it.academy.jpa.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @GetMapping("/item")
    public List<ItemEntity> getItemList() throws Exception {
        return itemService.getItemList();
    }

    @PostMapping("/item")
    public Map<String , Object> save(@RequestBody ItemEntity item){
        Map<String , Object> resultmap = new HashMap<>();
        try{
            resultmap = itemService.save(item);
        }catch(Exception e){
            e.printStackTrace();
            resultmap.put("resultMsg", "저장실패");
        }
        return resultmap;
    }

    @PutMapping("/item/{itemId}")
    public Map<String , Object> update(@PathVariable(name = "itemId")int itemId, @RequestBody ItemEntity item){
        Map<String , Object> resultmap = new HashMap<>();
        try{
            item.setItemId(itemId);
            resultmap = itemService.update(item);
        }catch(Exception e){
            e.printStackTrace();
            resultmap.put("resultMsg", "수정실패");
        }
        return resultmap;
    }

    @DeleteMapping("/item/{itemId}")
    public Map<String , Object> delete(@PathVariable(name = "itemId")int itemId){
        Map<String , Object> resultmap = new HashMap<>();
        try{
            resultmap = itemService.delete(itemId);
        } catch (Exception e) {
            e.printStackTrace();
            resultmap.put("resultMsg", "삭제실패");
        }
        return resultmap;
    }
}
