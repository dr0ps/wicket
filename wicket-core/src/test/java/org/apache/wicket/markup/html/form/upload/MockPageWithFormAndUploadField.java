/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.wicket.markup.html.form.upload;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.util.ListModel;

/**
 * Mock page for use in the FileUploadFieldTest
 * 
 * @author Frank Bille (billen)
 */
public class MockPageWithFormAndUploadField extends WebPage
{
	private static final long serialVersionUID = 1L;

	private final Form<?> form;
	private final FileUploadField fileUploadField;
	private FileUpload fileUpload;

	/**
	 * Construct.
	 */
	public MockPageWithFormAndUploadField()
	{
		final ListModel<FileUpload> model = new ListModel<FileUpload>();

		form = new Form<Void>("form")
		{
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit()
			{
				fileUpload = model.getObject().get(0);
			}
		};
		fileUploadField = new FileUploadField("upload", model);
		form.add(fileUploadField);
		add(form);
	}

	/**
	 * @return The form to attach the FileUploadField to.
	 */
	public Form<?> getForm()
	{
		return form;
	}

	/**
	 * @return fileUpload
	 */
	public FileUpload getFileUpload()
	{
		return fileUpload;
	}
}
