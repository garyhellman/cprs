/**
 * Copyright 2010-2011 Ralph Schaer <ralphschaer@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.acs.cprs.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import ch.ralscha.extdirectspring.annotation.ExtDirectMethod;
//import ch.ralscha.extdirectspring.annotation.ExtDirectMethodType;
//import ch.ralscha.extdirectspring.bean.ExtDirectStoreReadRequest;

@Service
public class SalesAction {

	@Autowired
	private PivotDataBean dataBean;

//	@ExtDirectMethod(value = ExtDirectMethodType.STORE_READ, group = "pivot")
//	public List<Sale> load(ExtDirectStoreReadRequest request) {
//		return dataBean.getSalesData();
//	}

	public List<Sale> load() {
		return dataBean.getSalesData();
	}
	
}
