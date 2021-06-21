<template>
  <div>
    <SidebarMenu :menu="menu" />
  </div>
</template>

<script>

export default {
  data() {
    return {
      menu: [
        {
            href: '/',
            header: true,
            title: 'Main Navigation',
            hiddenOnCollapse: true,
            icon: 'fa fa-user'
        },
        {
            href: '/',
            title: 'Dashboard',
            icon: 'fa fa-user'
        },
        {
            href: '/charts',
            title: 'Charts',
            icon: 'fa fa-chart-area',
            child: [
                {
                    href: '/charts/sublink',
                    title: 'Sub Link'
                }
            ]
        }
      ]
    }
  }
}
</script>

<style>

</style>