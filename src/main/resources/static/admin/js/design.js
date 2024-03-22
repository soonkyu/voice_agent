
/*--------------------menu*/
//nav
$('.nav a').click(function(){
	var idx = $('.nav a').index($(this));
	$('.nav a').removeClass('on').eq(idx).addClass('on');
});

/*--------------------textarea 자동 높이 조절*/
$('.tblBody textarea').keyup(function(e){
	$(this).css('height','auto');
	$(this).height(this.scrollHeight);
});

/*--------------------table*/
//paging
$('.paging ul button').click(function(){
	var idx = $('.paging ul button').index($(this));
	$('.paging ul button').removeClass('on').eq(idx).addClass('on');
});


/*--------------------button*/
$('.toggle').click(function(){
	$(this).toggleClass('on')
});

	
/*--------------------팝업*/
//팝업 닫기 버튼
$('.pop .close').click(function(){
	$(this).parents('.pop').removeClass('open');
	$('.tbl-body tr').removeClass('active')
});

//팝업 닫기
function popClose(obj){
	$(obj).parents('.pop').removeClass('open');
}

//toast 공통
function toast(toastTxt){
	var toast = '<section class="toast"><p>'+toastTxt+'</p></section>';
	$('body').append(toast);
	setTimeout(function(){
		$('.toast').remove();
	},1000);
}

//moreList 
$('.moreList a').click(function(){
	$(this).parents('.moreList').removeClass('open');
});



/*--------------------내정보*/
//내정보 open
function my(){
	$('#p_my').addClass('open');	
}

//핸드폰 번호 변경
function edit_phone(obj){
	$('#my_phoneEdit').show();
	$('#my_phoneView').hide();
	$('#my_phoneIpt').focus().val();
}

//핸드폰 변경 저장 버튼 활성 여부
$('#my_phoneIpt').keyup(function(){
	var length = $(this).val().length;
	if( length >= 13 ){
		$('#my_phoneChangeSave').prop('disabled',false);
	}
});

//핸드폰 변경 취소
$('#my_phoneChangeCancel').click(function(){
	$('#my_phoneEdit').hide();
	$('#my_phoneView').show();
});

//핸드폰 변경 저장 완료
$('#my_phoneChangeSave').click(function(){
	toast('핸드폰 번호가 변경 되었습니다.')
	$('#my_phoneEdit').hide();
	$('#my_phoneView').show();
	$('#my_phoneNum').text( $('#my_phoneIpt').val() );
});

//비밀번호 변경
function passwordChange(){
	$('#password_change').hide();
	$('#password_ipt').show();
	$('#passwordAvail1').focus();
}

//비밀번호 변경 완료
function passwordSave(){
	$('#password_change').show();
	$('#password_ipt').hide();
	toast('비밀번호가 변경 되었습니다.')
}

//비밀번호 유효성
$('#passwordAvail2').keyup(function(){
	var passwordAvail1 = $('#passwordAvail1').val();
	var passwordAvail2 = $('#passwordAvail2').val();

	if( passwordAvail1 == passwordAvail2 ){
		$('#password_cmt').removeClass('open');
		$('#passwordSave').prop('disabled', false );
	}else{
		$('#password_cmt').addClass('open');
		$('#passwordSave').prop('disabled', true );
	}
});

/*--------------------하이픈*/ 
const phHyphen = (target) => {
	target.value = target.value
	.replace(/[^0-9]/g, '')
	.replace(/^(\d{2,3})(\d{3,4})(\d{4})$/, `$1-$2-$3`);
}


/*--------------------내정보*/ 
//내 비밀번호 변경
function myPassword(){
	$('#p_passwordChange').addClass('open');
	$('#newPassword').focus();
}

//내 비밀번호 변경 저장
function myPasswordConf(obj){
	$(obj).parents('.pop').removeClass('open');
	toast('비밀번호가 변경되었습니다.')
}

//내 정보 저장
function myInfoSave(obj){
	$(obj).parents('.pop').removeClass('open');
	toast('정보가 변경되었습니다.')
}


/*--------------------경로*/
function my(){ $('#p_my').addClass('open')} /*내정보*/
function scenario(){window.location.href='../scenario/scenario.html'} /*시나리오 관리*/
function scenarioEdit(){window.location.href='../scenario/scenarioEdit.html'} /*시나리오 편집*/
function scenarioNew(){window.location.href='../scenario/scenarioEdit.html'} /*시나리오 생성*/
function script(){window.location.href='../script/script.html'} /*스크립트 관리*/
function student(){window.location.href='../user/student.html'} /*교육생 관리*/
function user(){window.location.href='../user/user.html'} /*사용자 관리*/
function logout(){window.location.href='../login.html'} /*로그아웃*/



