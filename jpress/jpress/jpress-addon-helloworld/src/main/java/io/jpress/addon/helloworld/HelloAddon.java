/**
 * Copyright (c) 2015-2016, Michael Yang 杨福海 (fuhai999@gmail.com).
 *
 * Licensed under the GNU Lesser General Public License (LGPL) ,Version 3.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.gnu.org/licenses/lgpl-3.0.txt
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.jpress.addon.helloworld;

import io.jpress.core.addon.Hooks;
import io.jpress.core.addon.IAddon;

public class HelloAddon implements IAddon {

	@Override
	public boolean onStart(Hooks hooks) {

		hooks.register(HelloHook.HOOK_PROCESS_CONTROLLER, HelloHook.class);
		
		System.out.println("=============HelloAddon started=============");
		
		return true;

	}

	@Override
	public boolean onStop() {
		
		return true;

	}

}
