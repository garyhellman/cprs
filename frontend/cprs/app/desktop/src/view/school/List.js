Ext.define('CPRS.view.school.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.schoollist',

    title : 'All Schools',
	closable: true,

    store: 'Schools',
    
    initComponent: function() {
    	
/*    	
        this.store = {
            fields: ['schoolname', 'pryear', 'meetingname',
                     'reviewers', 'state', 'progress', 'decision',
                     'dateuploaded', 'deadline', 'condition' ],
            data  : [
                {schoolname: 'Benton/Franklin Center',    
                	pryear: '2011',
                	meetingname: 'July-Denver',
                	reviewers: 'Mark/John',
                	state: 'Reviewed',
                	progress: 'A B C D',
                	decision: 'RMI',
                	dateuploaded: '07/14/2011',
                	deadline: '07/15/2011',
                	condition: 'Submittted'
                },
                {schoolname: 'Bancroft Elementary School', 
                	pryear: '2011',
                	meetingname: 'July-Denver',
                	reviewers: 'Mark/John',
                	state: 'Reviewed',
                	progress: 'A B C D',
                	decision: 'RMI',
                	dateuploaded: '07/14/2011',
                	deadline: '07/15/2011',
                	condition: 'Submittted'
                },
                {schoolname: 'Kanford High School', 
                    	pryear: '2011',
                    	meetingname: 'July-Denver',
                    	reviewers: 'Mark/John',
                    	state: 'Reviewed',
                    	progress: 'A B C D',
                    	decision: 'RMI',
                    	dateuploaded: '07/14/2011',
                    	deadline: '07/15/2011',
                    	condition: 'Submittted'
                },
                {schoolname: 'Kamlakin High School', 
                        	pryear: '2011',
                        	meetingname: 'July-Denver',
                        	reviewers: 'Mark/John',
                        	state: 'Reviewed',
                        	progress: 'A B C D',
                        	decision: 'RMI',
                        	dateuploaded: '07/14/2011',
                        	deadline: '07/15/2011',
                        	condition: 'Submittted'
                },
                {schoolname: 'Bancroft Elementary School', 
                            	pryear: '2011',
                            	meetingname: 'July-Denver',
                            	reviewers: 'Mark/John',
                            	state: 'Reviewed',
                            	progress: 'A B C D',
                            	decision: 'RMI',
                            	dateuploaded: '07/14/2011',
                            	deadline: '07/15/2011',
                            	condition: 'Submittted'
                },
                {schoolname: 'Brookland Elementary', 
                    	pryear: '2011',
                    	meetingname: 'June-Maine',
                    	reviewers: 'Ken/Gary',
                    	state: 'Reviewed',
                    	progress: '',
                    	decision: 'Approved',
                    	dateuploaded: '',
                    	deadline: '',
                    	condition: 'Complete'
                }
            ]
        };
*/
        this.columns = [
            {header: 'School Name',  dataIndex: 'schoolname',  flex: 1},
            {header: 'PR Year', dataIndex: 'pryear', flex: 1},
            {header: 'Meeting Name', dataIndex: 'meetingname', flex: 1},
            {header: 'Reviewers', dataIndex: 'reviewers', flex: 1},
            {header: 'State', dataIndex: 'state', flex: 1},
            {header: 'Progress', dataIndex: 'progress', flex: 1},
            {header: 'Decision', dataIndex: 'decision', flex: 1},
            {header: 'Date Uploaded', dataIndex: 'dateuploaded', flex: 1},
            {header: 'Deadline', dataIndex: 'deadline', flex: 1},
            {header: 'Condition', dataIndex: 'condition', flex: 1}
        ];

        this.callParent(arguments);
    }
});
