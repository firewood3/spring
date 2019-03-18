package com.firewood.springrest01.notice.service;

import com.firewood.springrest01.notice.domain.Notice;
import com.firewood.springrest01.notice.domain.builder.NoticeBuilder;
import com.firewood.springrest01.notice.domain.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class NoticeService {

    private final NoticeRepository noticeRepository;

    @Autowired
    public NoticeService(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    public List<Notice> getAllNotice() {
        return noticeRepository.findAll();
    }

    public Optional<Notice> getOneNotice(Long id) {
        return noticeRepository.findById(id);
    }

    public Notice createNotice(NoticeBuilder noticeBuilder) {
        return noticeRepository.save(noticeBuilder.build());
    }

    @Transactional
    public Optional<Notice> updateNotice(Long id, NoticeBuilder noticeBuilder) throws EntityNotFoundException {
        Optional<Notice> notice = noticeRepository.findById(id);
        if(notice.isPresent()) {
            notice.get().setTitle(noticeBuilder.getTitle());
            notice.get().setContent(noticeBuilder.getContent());
        }
        return notice;
    }

    public void deleteNotice(Long id) throws EntityNotFoundException{
        noticeRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        noticeRepository.deleteById(id);
    }


}
