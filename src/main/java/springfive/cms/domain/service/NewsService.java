package springfive.cms.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springfive.cms.domain.models.News;
import springfive.cms.domain.repository.NewsRepository;
import springfive.cms.domain.vo.NewsRequest;

import java.util.List;
import java.util.UUID;

@Service
public class NewsService {
  private final NewsRepository newsRepository;

  @Autowired
  public NewsService(NewsRepository newsRepository) {
    this.newsRepository = newsRepository;
  }

  public News update(String id, NewsRequest newsRequest) {
    final News news = new News();
    news.setId(id);
    news.setTitle(newsRequest.getTitle());
    news.setContent(newsRequest.getContent());
    news.setCategories(newsRequest.getCategories());
    news.setTags(newsRequest.getTags());
    return this.newsRepository.save(news);
  }

  public News create(NewsRequest newsRequest) {
    final News news = new News();
    news.setId(UUID.randomUUID().toString());
    news.setTitle(newsRequest.getTitle());
    news.setContent(newsRequest.getContent());
    news.setCategories(newsRequest.getCategories());
    news.setTags(newsRequest.getTags());
    return this.newsRepository.save(news);
  }

  public void delete(String id) {
    final News news = this.newsRepository.findOne(id);
    this.newsRepository.delete(news);
  }

  public News findOne(String id) {
    return this.newsRepository.findOne(id);
  }

  public List<News> findAll() {
    return this.newsRepository.findAll();
  }
}
