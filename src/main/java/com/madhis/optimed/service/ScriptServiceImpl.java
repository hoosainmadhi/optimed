package com.madhis.optimed.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madhis.optimed.entity.Script;
import com.madhis.optimed.repository.ScriptRepository;


@Service
public class ScriptServiceImpl implements ScriptService{
		
		@Autowired
		private ScriptRepository scriptRepository;

		@Override
		public Script saveScript(Script script) {
			return scriptRepository.save(script);
		}
}
