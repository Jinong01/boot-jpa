package kr.it.academy.jpa.service;

import kr.it.academy.jpa.entity.ItemEntity;
import kr.it.academy.jpa.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public List<ItemEntity> getItemList() throws Exception {
        return itemRepository.findAll();
    }

    public Map<String, Object> save(ItemEntity item) {
        itemRepository.save(item);
        Map<String, Object> result = new HashMap<>();
        result.put("resultMsg", "등록 성공");
        return result;
    }

    public Map<String, Object> update(ItemEntity item) throws Exception {
        ItemEntity saved = itemRepository.findById(item.getItemId())
                .orElseThrow(() -> new ClassNotFoundException("찾는 객체가 없음."));

        //넘어온 데이터가 없으면 기존 값으로 name 을 채운다
        item.setItemName(item.getItemName() != null ? item.getItemName() : saved.getItemName());
        item.setItemPrice(item.getItemPrice() > 0 ? item.getItemPrice() : saved.getItemPrice());

        itemRepository.save(item);
        Map<String, Object> result = new HashMap<>();
        result.put("resultMsg", "수정 성공");

        return result;
    }

    public Map<String, Object> delete(int itemId)throws Exception {
        Map<String, Object> result = new HashMap<>();

        ItemEntity saved = itemRepository.findById(itemId)
                .orElseThrow(() -> new ClassNotFoundException("찾는 객체가 없음."));

        itemRepository.delete(saved);
        result.put("resultMsg", "삭제성공");
        return result;
    }
}
