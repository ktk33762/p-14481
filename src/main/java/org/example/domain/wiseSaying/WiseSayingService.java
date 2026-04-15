package org.example.domain.wiseSaying;

import org.example.AppContext;
import org.example.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingService {
    private final WiseSayingRepository wiseSayingRepository;
    private final List<WiseSaying> wiseSayingList = new ArrayList<>();

    public WiseSayingService () {
        wiseSayingRepository = AppContext.wiseSayingRepository;
    }

    public WiseSaying write (String content, String author) {
        WiseSaying wiseSaying = new WiseSaying(author, content);
        wiseSayingRepository.save(wiseSaying);

        return wiseSaying;
    }

    public List<WiseSaying> findForList () {
        return wiseSayingRepository.findForList();
    }

    public void delete(WiseSaying wiseSaying) {
        wiseSayingList.remove(wiseSaying);
    }

    public boolean delete(int id) {
        WiseSaying wiseSaying = wiseSayingRepository.findById(id);

        if (wiseSaying == null) return false;

        wiseSayingRepository.delete(wiseSaying);

        return true;
    }

    public WiseSaying findById(int id) {
        return wiseSayingRepository.findById(id);
    }

    public void modify(WiseSaying wiseSaying, String modifyContent, String modifyAuthor) {
        wiseSaying.setContent(modifyContent);
        wiseSaying.setAuthor(modifyAuthor);

        wiseSayingRepository.save(wiseSaying);
    }

    public List<WiseSaying> findForList(String keywordType, String keyword) {
        if (keyword.isBlank()) {
            return wiseSayingRepository.findForList();
        }

        return switch (keywordType) {
            case "content" -> wiseSayingRepository.findByKeywordTypeAndKeyword(keyword);
            case "author" -> wiseSayingRepository.findForListByAuthorContaining(keyword);
            default -> wiseSayingRepository.findForListByAuthororContentContaining(keyword);
        };
    }
}
