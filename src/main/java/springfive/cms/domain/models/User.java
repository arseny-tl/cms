package springfive.cms.domain.models;

import lombok.Data;
import org.springframework.context.annotation.Role;

@Data
public class User {
  String id;
  String identity;
  String name;
  Role role;
}
