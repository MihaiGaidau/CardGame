package com.gaidau.cardGame.repository;

import com.gaidau.cardGame.bean.MathExpression;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpressionRepository extends JpaRepository<MathExpression, Integer> {
}
