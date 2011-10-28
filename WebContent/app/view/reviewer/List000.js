Ext.define('CPRS.view.reviewer.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.reviewerlist',

    title : 'All Reviewers',
	closable: true,

    store: 'Reviewers',
    
    initComponent: function() {
    	
/*    	
        this.store = {
            fields: ['reviewername', 'pryear', 'meetingname',
                     'reviewers', 'state', 'progress', 'decision',
                     'dateuploaded', 'deadline', 'condition' ],
            data  : [
                {reviewername: 'Benton/Franklin Center',    
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
                {reviewername: 'Bancroft Elementary Reviewer', 
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
                {reviewername: 'Kanford High Reviewer', 
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
                {reviewername: 'Kamlakin High Reviewer', 
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
                {reviewername: 'Bancroft Elementary Reviewer', 
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
                {reviewername: 'Brookland Elementary', 
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
            {header: 'Reviewer',  dataIndex: 'reviewer',  flex: 1},
            {header: 'Phone', dataIndex: 'phone', flex: 1},
            {header: 'Email', dataIndex: 'email', flex: 1},
            {
            	header: ' ',
            	type: 'action'
            }
        ];

        this.callParent(arguments);
    }
});
