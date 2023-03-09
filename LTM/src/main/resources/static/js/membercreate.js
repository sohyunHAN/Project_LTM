  const hypenTel = (target) => {
 target.value = target.value
   .replace(/[^0-9]/g, '')
   .replace(/^(\d{2,3})(\d{3,4})(\d{4})$/, `$1-$2-$3`);
}

  'use strict';

  const form = document.querySelector('#form__wrap');
  const checkAll = document.querySelector('.terms__check__all input');
  const checkBoxes = document.querySelectorAll('.input__check input');
  const submitButton = document.querySelector('button');

  const agreements = {
    termsOfService: false,
    privacyPolicy: false,
    allowPromotions: false,
  };

  form.addEventListener('submit', (e) => e.preventDefault()); // 새로고침(submit) 되는 것 막음

  checkBoxes.forEach((item) => item.addEventListener('input', toggleCheckbox));

  function toggleCheckbox(e) {
    const { checked, id } = e.target;  
    agreements[id] = checked;
    this.parentNode.classList.toggle('active');
    checkAllStatus();
    toggleSubmitButton();
  }

  function checkAllStatus() {
    const { termsOfService, privacyPolicy, allowPromotions } = agreements;
    if (termsOfService && privacyPolicy && allowPromotions) {
      checkAll.checked = true;
    } else {
      checkAll.checked = false;
    }
  }

  function toggleSubmitButton() {
    const { termsOfService, privacyPolicy } = agreements;
    if (termsOfService && privacyPolicy) {
      submitButton.disabled = false;
    } else {
      submitButton.disabled = true;
    }
  }

  checkAll.addEventListener('click', (e) => {
    const { checked } = e.target;
    if (checked) {
      checkBoxes.forEach((item) => {
        item.checked = true;
        agreements[item.id] = true;
        item.parentNode.classList.add('active');
      });
    } else {
      checkBoxes.forEach((item) => {
        item.checked = false;
        agreements[item.id] = false;
        item.parentNode.classList.remove('active');
      });
    }
    toggleSubmitButton();
  });

  function checkAgree(){
      var agreement1 = document.getElementById('agreement1');
        var agreement2 = document.getElementById('agreement2');
        if(agreement1.checked == false) {
            alert("필수항목동의")
            return false;
        }else if(agreement2.checked == false){
        alert("필수항목동의")
           return false;
            }
        }