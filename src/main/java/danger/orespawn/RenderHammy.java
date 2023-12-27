/*     */ package danger.orespawn;
/*     */ 
/*     */ import cpw.mods.fml.client.FMLClientHandler;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraftforge.client.IItemRenderer;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RenderHammy
/*     */   implements IItemRenderer
/*     */ {
/*  15 */   private static final ResourceLocation texture = new ResourceLocation("orespawn", "AttitudeAdjustertexture.png");
/*     */ 
/*     */ 
/*     */   
/*  19 */   protected ModelHammy modelHammy = new ModelHammy();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type) {
/*  26 */     switch (type) {
/*     */ 
/*     */       
/*     */       case EQUIPPED:
/*  30 */         return true;
/*     */       
/*     */       case EQUIPPED_FIRST_PERSON:
/*  33 */         return true;
/*     */     } 
/*  35 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper) {
/*  44 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data) {
/*  51 */     switch (type) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case EQUIPPED:
/*  57 */         renderSwordF5(6.0F, -20.0F, -4.0F, 0.15F);
/*     */         break;
/*     */ 
/*     */ 
/*     */       
/*     */       case EQUIPPED_FIRST_PERSON:
/*  63 */         renderSword(-10.0F, -13.0F, -5.0F, 0.15F);
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void renderSword(float x, float y, float z, float scale) {
/*  76 */     GL11.glPushMatrix();
/*     */ 
/*     */     
/*  79 */     GL11.glRotatef(70.0F, 0.0F, 1.0F, 0.0F);
/*  80 */     GL11.glRotatef(190.0F, 1.0F, 0.0F, 0.0F);
/*  81 */     GL11.glRotatef(25.0F, 0.0F, 0.0F, 1.0F);
/*     */     
/*  83 */     GL11.glScalef(scale, scale, scale);
/*  84 */     GL11.glTranslatef(x, y, z);
/*     */ 
/*     */     
/*  87 */     (FMLClientHandler.instance().getClient()).renderEngine.bindTexture(texture);
/*  88 */     this.modelHammy.render();
/*     */     
/*  90 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void renderSwordF5(float x, float y, float z, float scale) {
/*  99 */     GL11.glPushMatrix();
/*     */ 
/*     */     
/* 102 */     GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
/*     */     
/* 104 */     GL11.glScalef(scale, scale, scale);
/* 105 */     GL11.glTranslatef(x, y, z);
/*     */ 
/*     */     
/* 108 */     (FMLClientHandler.instance().getClient()).renderEngine.bindTexture(texture);
/* 109 */     this.modelHammy.render();
/*     */     
/* 111 */     GL11.glPopMatrix();
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\RenderHammy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */