<%@ include file="/common/taglibs.jsp" %>
<head>
    <title><fmt:message key="personList.title"/></title>
    
</head>
<div class="col-sm-10">
    <h2><fmt:message key='channels.heading'/></h2>

    <div id="actions" class="btn-group">
        <a class="btn btn-primary" href="<c:url value='form'/>">
            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/></a>
        <a class="btn btn-default" href="<c:url value='/mainMenu'/>">
            <i class="icon-ok"></i> <fmt:message key="button.done"/></a>
    </div>

    <display:table name="channels" class="table table-condensed table-striped table-hover" requestURI=""
                   id="channels" export="true" pagesize="25">
        <display:column property="channelId.id" sortable="true" href="form" media="html"
                        paramId="id" paramProperty="channelId.id" titleKey="channelDto.channelId"/>
        <display:column property="channelId.id" media="csv excel xml pdf" titleKey="channelDto.channelId"/>
        <display:column property="title" sortable="true" titleKey="channelDto.title"/>
        
        <display:setProperty name="paging.banner.item_name">
        <fmt:message key="channels.channel"/>
        </display:setProperty>
        <display:setProperty name="paging.banner.items_name">
        <fmt:message
                key="channels.list"/></display:setProperty>
        <display:setProperty name="export.excel.filename"><fmt:message
                key="channels.title"/>.xls</display:setProperty>
        <display:setProperty name="export.csv.filename"><fmt:message key="channels.title"/>.csv</display:setProperty>
        <display:setProperty name="export.pdf.filename"><fmt:message key="channels.title"/>.pdf</display:setProperty>
    </display:table>
</div>