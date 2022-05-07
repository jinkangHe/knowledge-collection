package com.knowledge.thread.threadlocal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * @author Jinkang He
 * @version 1.0
 * @date 2022/5/6 11:08
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Authentication {

  private String username;
  private String role;
}
